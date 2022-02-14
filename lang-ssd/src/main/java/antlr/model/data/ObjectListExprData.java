package antlr.model.data;

import java.util.List;

public class ObjectListExprData implements ExprData<List<?>> {
    private List<?> list;
    public ObjectListExprData(List<?> list) {
        this.list=list;
    }
    @Override
    public List<?> getData() {
        return list;
    }
}