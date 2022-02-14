package antlr.expr.listens;

import antlr.model.ErrorInfo;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class ExpressionErrorListener extends BaseErrorListener {
    private StringBuffer sb;
    private List<ErrorInfo> infos=new ArrayList<ErrorInfo>();
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        infos.add(new ErrorInfo(line,charPositionInLine,msg));
        if(sb==null){
            sb=new StringBuffer();
        }
        sb.append("["+offendingSymbol+"] is invalid:"+msg);
        sb.append("\r\n");
        //e.printStackTrace();
    }
    public String getErrorMessage(){
        if(sb==null){
            return null;
        }
        return sb.toString();
    }
    public List<ErrorInfo> getInfos() {
        return infos;
    }
}
