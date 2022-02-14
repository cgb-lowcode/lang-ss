package antlr.model;


import antlr.CalException;

/**
 * @author Jacky.gao
 * @since 2016年11月22日
 */
public enum Op {
    GreatThen,EqualsGreatThen,LessThen,EqualsLessThen,Equals,NotEquals,In,NotIn,Like,NotLike;
    public static Op parse(String op)  {
        op=op.trim();
        if(op.equals(">")){
            return GreatThen;
        }else if(op.equals(">=")){
            return EqualsGreatThen;
        }else if(op.equals("==")){
            return Equals;
        }else if(op.equals("<")){
            return LessThen;
        }else if(op.equals("<=")){
            return EqualsLessThen;
        }else if(op.equals("!=")){
            return NotEquals;
        }else if(op.equals("<>")){
            return NotEquals;
        }else if(op.equals("in")){
            return In;
        }else if(op.equals("not in") || op.equals("not  in")){
            return NotIn;
        }else if(op.equals("like")){
            return Like;
        }else if(op.equals("not like") || op.equals("not  like")){
            return NotLike;
        }
        throw new CalException("Unknow op :"+op);
    }
    @Override
    public String toString() {
        switch(this){
            case GreatThen:
                return ">";
            case EqualsGreatThen:
                return ">=";
            case LessThen:
                return "<";
            case EqualsLessThen:
                return "<=";
            case Equals:
                return "==";
            case NotEquals:
                return "!=";
            case In:
                return " in ";
            case NotIn:
                return " not in ";
            case Like:
                return " like ";
            case NotLike:
                return " not like ";
        }
        return super.toString();
    }
}

