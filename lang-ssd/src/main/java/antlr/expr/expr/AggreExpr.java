package antlr.expr.expr;

import antlr.expr.builder.aggregate.AggregateFactory;
import antlr.expr.builder.aggregate.IAggregate;
import antlr.model.data.ExprData;
import cal.SSExprParser;
import main.MyExprContext;
import org.jsoup.Connection;

public class AggreExpr extends BaseExpr{
    private String  name;
    private SSExprParser.DatasetContext datesetContext;
    public AggreExpr(String name, SSExprParser.DatasetContext datasetContext){
        this.name = name;
        this.datesetContext = datasetContext;
    }

    @Override
    protected ExprData<?> compute(MyExprContext context) {
        IAggregate action = AggregateFactory.instance().aggregate(name);
        BaseExpr expr = action.expr(context,datesetContext);
        return expr.run(context);
    }
}
