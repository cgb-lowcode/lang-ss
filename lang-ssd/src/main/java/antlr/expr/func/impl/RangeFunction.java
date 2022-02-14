package antlr.expr.func.impl;

import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import cn.hutool.core.convert.Convert;
import main.MyExprContext;

import java.util.ArrayList;
import java.util.List;

public class RangeFunction implements Function {
    //range(start,end,step)
    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext context) {
        List<Object> list= new ArrayList<Object>();
        int start = 0, end=0,step = 1;
        if(dataList!=null){
            if(dataList.size()==1){
                ExprData thisEnd = dataList.get(0);
                end = Convert.toInt(thisEnd.getData());
            }else if(dataList.size()==2){
                start = Convert.toInt(dataList.get(0).getData());
                end = Convert.toInt(dataList.get(1).getData());
            }else if(dataList.size()==3){
                start = Convert.toInt(dataList.get(0).getData());
                end = Convert.toInt(dataList.get(1).getData());
                step = Convert.toInt(dataList.get(2).getData());
            }
            for(int i=start;i<end;i+=step){
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public String name() {
        return "range";
    }
}
