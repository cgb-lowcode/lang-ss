package antlr.expr.func.impl;

import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import main.MyExprContext;

import java.util.ArrayList;
import java.util.List;

public class ListFunction implements Function {

    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext context) {
        List<Object> list= new ArrayList<Object>();
        for(ExprData<?> d:dataList){
            if(d instanceof ObjectExprData){
                ObjectExprData exprData=(ObjectExprData)d;
                list.add(exprData.getData());
            }else if(d instanceof ObjectListExprData){
                ObjectListExprData listData=(ObjectListExprData)d;
                list.addAll(listData.getData());
            }
        }
        return list;
    }

    @Override
    public String name() {
        return "list";
    }
}
