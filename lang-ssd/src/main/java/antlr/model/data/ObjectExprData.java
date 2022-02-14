package antlr.model.data;

public class ObjectExprData implements ExprData<Object> {
    private Object data;
    public ObjectExprData(Object data) {
        this.data=data;
    }
    @Override
    public Object getData() {
        return data;
    }
}
