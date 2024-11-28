grammar Mx;

@header {package Grammar;}

program : (classDef | varDef | funcDef)* EOF;

expressionlist : expression (',' expression)*;

funcDef : typename name=Identifier '(' arglist? ')' body=suite;
arglist : arg (',' arg)*;
arg : typename argvar;
argvar : name=Identifier ('=' expression)?;
varDef : typename argvar (',' argvar)*? ';';
array : '[' expression? ']'; 
arrayinitial : '{' expressionlist? '}';
typename : type ('[' ']')*?;
type : Identifier | Bool | Int | String | Void;
literal : False | True | Null | ConstString | DecimalInteger;
formstr : FormatString | (FormatStringL expression (FormatStringM expression)? FormatStringR);

expression
    : '(' expression ')' # ParenExpr
    | name=expression '[' index=expression ']' #ArrayExpr
    | New type array+ arrayinitial? # NewArrayExpr
    | New type ('(' ')')? #NewVarExpr
    | expression Dot Identifier # MemberExpr
    | expression '(' expressionlist ')' # FuncExpr
    | lhs=expression op=(Inc | Dec) # RightExpr
    | <assoc = right> op=(Inc | Dec) rhs=expression  # LeftExpr
    | <assoc = right> op=(Not | BitNot | Sub) rhs=expression # LeftExpr
    | lhs=expression op=(Mul | Div | Mod) rhs=expression # BinaryOpExpr
    | lhs=expression op=(Add | Sub) rhs=expression # BinaryOpExpr
    | lhs=expression op=(RightShift | LeftShift) rhs=expression # BinaryOpExpr
    | lhs=expression op=(Ge | Le | Geq | Leq) rhs=expression # BinaryCmpExpr
    | lhs=expression op=(Neq | Eq) rhs=expression # BinaryCmpExpr
    | lhs=expression op=BitAnd rhs=expression # BinaryOpExpr
    | lhs=expression op=BitXor rhs=expression # BinaryOpExpr
    | lhs=expression op=BitOr rhs=expression # BinaryOpExpr
    | lhs=expression op=And rhs=expression # BinaryOpExpr
    | lhs=expression op=Or rhs=expression # BinaryOpExpr
    | <assoc = right> cond=expression Question thenstmt=expression Colon elsestmt=expression # TernaryExpr
    | <assoc = right> lhs=expression op=Assign rhs=expression # AssignExpr
    | arrayinitial # ArrayInitExpr
    | literal # LiteralExpr
    | formstr # FormatStringExpr
    | Identifier # AtomExpr
    | This # AtomExpr
    ;

classDef : Class Identifier '{' (varDef | funcDef | classConstruct)* '}' ';';
classConstruct : name=Identifier '(' ')' body=suite;

suite : '{' statement* '}';

statement
    : suite # suiteStmt
    | varDef # varDefStmt
    | If '(' cond=expression ')' thenstmt=statement (Else elsestmt=statement)? # ifStmt
    | Return expression? ';' # returnStmt
    | expression ';' # pureExprStmt
    | ';' # emptyStmt
    | For '(' init=statement cond=statement step=expression? ')' body=statement # forStmt
    | While '(' cond=expression ')' body=statement # whileStmt
    | (Continue | Break) ';' # jumpStmt
    ;

Add : '+';
Sub : '-';
Mul : '*';
Div : '/';
Mod : '%';

Ge : '>';
Le : '<';
Geq : '>=';
Leq : '<=';
Neq : '!=';
Eq : '==';

And : '&&';
Or : '||';
Not : '!';

RightShift : '>>';
LeftShift : '<<';
BitAnd : '&';
BitOr : '|';
BitXor : '^';
BitNot : '~';

Assign : '=';

Inc : '++';
Dec : '--';

Dot : '.';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Void : 'void';
Bool : 'bool';
Int : 'int';
String : 'string';
New : 'new';
Class : 'class';
Null : 'null';
True : 'true';
False : 'false';
This : 'this';
If : 'if';
Else : 'else';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';

fragment EscapeCharacter : '\\\\' | '\\n' | '\\"';
fragment StringCharacter : EscapeCharacter | ~[\n\\"];
fragment FormatStringCharacter : EscapeCharacter | ~[\n\\"$] | '$$';

Identifier
    : [a-zA-Z] [a-zA-Z_0-9]*
    ;

DecimalInteger
    : [1-9] [0-9]*
    | '0'
    ;

ConstString
    : '"' StringCharacter*? '"'
    ;

FormatString
    : 'f"'  FormatStringCharacter*? '"';

FormatStringL
    : 'f"' FormatStringCharacter*? '$';

FormatStringM
    : '$' FormatStringCharacter*? '$';

FormatStringR
    : '$' FormatStringCharacter*? '"';

Whitespace
    :   (   ' '
        |   '\t'
        )
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        |   '\r'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;