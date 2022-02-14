grammar SSExpr;
import SSLexer;
stat: expression+ EOF;

expression: exprComposite
    | ifExpr
    | forInExpr
    | returnExpr
    | varAssign
    | eachExpr
;

exprComposite : expr 										#singleExprComposite
              | exprLogic                                   #singleExprLogicComposite
			  | ternaryExpr									#ternaryExprComposite
			  | LeftParen exprComposite RightParen 			#parenExprComposite
			  | exprComposite Opertion exprComposite		#complexExprComposite
              ;
forInExpr: 'for' LeftParen (variable ',')? variable 'in' unit RightParen LEFTBLOCK block RIGHTBLOCK;

ifExpr: ifPart elseIfPart* elsePart? ;
ifPart : 'if' LeftParen tests RightParen LEFTBLOCK block RIGHTBLOCK;
elseIfPart : 'else' 'if' LeftParen tests RightParen LEFTBLOCK block RIGHTBLOCK ;
elsePart : 'else' LEFTBLOCK block RIGHTBLOCK ;

augassign: ('+=' | '-=' | '*=' | '/=' | '%=');

block : exprBlock* returnExpr? ;
exprBlock :expression;
eachExpr : unit '.each' LeftParen variable ARROW LEFTBLOCK? block RIGHTBLOCK? RightParen;
returnExpr : 'return'? exprComposite ';'?;

consts: PI|EE|EB|MIU;

expr:   dataset                 #exprDataset
        |expr '[' expr ']'   #exprArrIndex
        |expr '.' Identifier   #exprPropDot
        |item (Opertion unit)*   #exprItemUnit
        |item (Opertion item)*  #exprItemItem
        ;

exprLogic: itemLogic (join itemLogic)*;

varAssign:leftHandSide ('='|augassign) exprComposite;

leftHandSide: variable
               | arrayAccess
               ;

arrayAccess:	variable '[' expr ']';

ternaryExpr : test (join test)* '?' block ':' block ;
test : expr OP expr;
tests : test (join test)*;
item:   unit (Opertion unit)*     #simpleCal
        | LeftParen item RightParen                  # parens
        | LeftParen item (Opertion item)+ RightParen		#parenJoin
;
itemLogic: unit    #simpleValueLogicUnit
        | test     #simpleCalLogic
        | LeftParen itemLogic RightParen                  # parensLogic
        | LeftParen itemLogic (join itemLogic)+ RightParen		#parenJoinLogic
;

//数据集的写法，表.select(),数据源.表.select()，宏观指标()等
properties : STRING | obj;
orders: STRING;

dataset_test : Identifier OP expr;
dataset_tests : dataset_test (join dataset_test)*;
dataset : Identifier '.' (Identifier '.')? aggregate '(' properties? (',' dataset_tests )? (',' orders)? ')';

aggregate : Identifier;

unit:
      variable op=('++' | '--')
      | <assoc=right> op=('++'|'--') variable
      | <assoc=right> op=('!' | 'not') variable
      | function
      | variable
      | consts
      | simpleValue
      | json
;

pair: STRING ':' expr;

json:obj|arr;

obj
   : '{' pair (',' pair)* '}'
   | '{' '}'
   ;
arr: '[' unit (',' unit)* ']'
   | '[' obj (',' obj)* ']'
   | '[' ']'
   ;

simpleValue : INTEGER|NUMBER|IMAG_NUMBER|STRING|BOOLEAN|NULL;

function : Identifier '(' functionParameter? ')' ;
functionParameter : expr (','? expr)* ;

join : AND | OR ;


variable :  Identifier ;


WS
:
	[ \t\r\n]+ -> channel(HIDDEN)
;

NL
:
    '\r'? '\n' ->channel(HIDDEN)
;
PI: 'PI';
MIU:'MIU';
EB:'EB';
EE:'EE';