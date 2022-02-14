package com.sumslack.webapp.controller;

import antlr.CalException;
import antlr.expr.ParseExprUtil;
import antlr.expr.expr.Expr;
import antlr.model.ErrorInfo;
import antlr.model.data.ExprData;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONUtil;
import com.sumslack.webapp.common.Result;
import com.sumslack.webapp.service.WsService;
import com.sumslack.webapp.vo.CodeVO;
import com.sumslack.webapp.vo.PrintVO;
import io.swagger.annotations.ApiOperation;
import main.MyExprContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coding")
public class LangController {

    @Autowired
    private WsService wsService;

    @PostMapping("/run")
    @ApiOperation("运行代码，获取结果")
    public Result<?> run(@RequestBody CodeVO codeVO){
        MyExprContext context = new MyExprContext();
        if(codeVO.getParams()!=null){
            if(JSONUtil.isJsonObj(codeVO.getParams())){
                context.setParameters(JSONUtil.toBean(codeVO.getParams(),Map.class));
            }
        }
        Expr expression= null;
        ExprData result = null;
        try {
            //先检查语法
            List<ErrorInfo> errors = ParseExprUtil.validation(codeVO.getCode());
            if(errors!=null && errors.size()>0){
                return Result.error("!!!!语法错误，请检查编辑器左侧的错误图标查看错误详情!!!");
            }
            expression = ParseExprUtil.parseExpression(codeVO.getCode());
            result = expression.run(context);
            return Result.ok(result);
        }catch(CalException ex){
            //wsService.boardcast(ExceptionUtil.getMessage(ex),"error");
            //return Result.error(ExceptionUtil.getMessage(ex));
            ex.printStackTrace();
            return Result.error("!!!!!运行错误！!!!!");
        }
    }

    @PostMapping("/validation")
    @ApiOperation("检查代码")
    public Result<?> validation(@RequestBody CodeVO codeVO){
        List<ErrorInfo> errors = ParseExprUtil.validation(codeVO.getCode());
        return Result.ok(errors);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
