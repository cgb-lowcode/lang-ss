package antlr.model;

import antlr.CalException;

public enum Operator {
    Add,Subtract,Multiply,Divide,Complementation;
    public static Operator parse(String op)  {
        if(op.equals("+")){
            return Add;
        }else if(op.equals("-")){
            return Subtract;
        }else if(op.equals("*")){
            return Multiply;
        }else if(op.equals("/")){
            return Divide;
        }else if(op.equals("%")){
            return Complementation;
        }else{
            throw new CalException("Unknow operator :"+op);
        }
    }
    @Override
    public String toString() {
        switch(this){
            case Add:
                return "+";
            case Divide:
                return "/";
            case Multiply:
                return "*";
            case Subtract:
                return "-";
            case Complementation:
                return "%";
        }
        throw new IllegalArgumentException("Unknow operator: ["+this+"]");
    };
}
