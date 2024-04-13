package org.example.lexer;

import java.io.*;
import java_cup.runtime.*;
import javax.swing.JOptionPane;
import org.example.cup.*;

%%


%public
%class Lexer
%unicode
%line
%column
%cup

digit = [0-9]+
letter = [a-zA-Z]
lineTerminator = \r|\n|\r|n
spaceWhite = [  |\t|\f ] | {lineTerminator}
word = {letter}({letter} | {digit})+
comillas = "\""

%eofval{
    return new Symbol(ParserSym.EOF);
%eofval}



%%





"NUEVO_SITIO_WEB"       {return new Symbol(ParserSym.NUEVO_SITIO_WEB, yycolumn, yyline, yytext());}
"ID"                    {return new Symbol(ParserSym.ID, yycolumn, yyline, yytext());}
"USUARIO_CREACION"      {return new Symbol(ParserSym.USUARIO_CREACION, yycolumn, yyline, yytext());}
"FECHA_CREACION"        {return new Symbol(ParserSym.FECHA_CREACION, yycolumn, yyline, yytext());}
"FECHA_MODIFICACION"    {return new Symbol(ParserSym.FECHA_MODIFICACION, yycolumn, yyline, yytext());}
"USUARIO_MODIFICACION"  {return new Symbol(ParserSym.USUARIO_MODIFICACION, yycolumn, yyline, yytext());}
"BORRAR_SITIO_WEB"      {return new Symbol(ParserSym.BORRAR_SITIO_WEB, yycolumn, yyline, yytext());}
"NUEVA_PAGINA"          {return new Symbol(ParserSym.NUEVA_PAGINA, yycolumn, yyline, yytext());}
"TITULO"                {return new Symbol(ParserSym.TITULO, yycolumn, yyline, yytext());}
"SITIO"                 {return new Symbol(ParserSym.SITIO, yycolumn, yyline, yytext());}
"PADRE"                 {return new Symbol(ParserSym.PADRE, yycolumn, yyline, yytext());}
"MODIFICAR_PAGINA"      {return new Symbol(ParserSym.MODIFICAR_PAGINA, yycolumn, yyline, yytext());}
"BORRAR_PAGINA"         {return new Symbol(ParserSym.BORRAR_PAGINA, yycolumn, yyline, yytext());}
"PAGINA"                {return new Symbol(ParserSym.PAGINA, yycolumn, yyline, yytext());}
"CLASE"                 {return new Symbol(ParserSym.CLASE, yycolumn, yyline, yytext());}
"AGREGAR_COMPONENTE"    {return new Symbol(ParserSym.AGREGAR_COMPONENTE, yycolumn, yyline, yytext());}
"BORRAR_COMPONENTE"     {return new Symbol(ParserSym.BORRAR_COMPONENTE, yycolumn, yyline, yytext());}
"PARAMETRO"             {return new Symbol(ParserSym.PARAMETRO, yycolumn, yyline, yytext());}
"PARAMETROS"            {return new Symbol(ParserSym.PARAMETROS, yycolumn, yyline, yytext());}
"nombre"                {return new Symbol(ParserSym.NOMBRE, yycolumn, yyline, yytext());}
"="                     {return new Symbol(ParserSym.IGUAL, yycolumn, yyline, yytext());}
"<ATRIBUTO"             {return new Symbol(ParserSym.INITATRIBUT, yycolumn, yyline, yytext());}
"</ATRIBUTO>"           {return new Symbol(ParserSym.ENDATRIBUT, yycolumn, yyline, yytext());}
"<ATRIBUTOS>"           {return new Symbol(ParserSym.INITATRIBUTOS, yycolumn, yyline, yytext());}
"</ATRIBUTOS>"          {return new Symbol(ParserSym.ENDATRIBUTOS, yycolumn, yyline, yytext());}
"<accion"               {return new Symbol(ParserSym.INITACCION, yycolumn, yyline, yytext());}
"</accion>"             {return new Symbol(ParserSym.ENDACCION, yycolumn, yyline, yytext());}
"<acciones>"            {return new Symbol(ParserSym.INITACCIONES, yycolumn, yyline, yytext());}
"</acciones>"           {return new Symbol(ParserSym.ENDACCIONES, yycolumn, yyline, yytext());}
"<parametro"            {return new Symbol(ParserSym.INITPARAMETRO, yycolumn, yyline, yytext());}
"</parametro>"          {return new Symbol(ParserSym.ENDPARAMETRO, yycolumn, yyline, yytext());}
"<parametros>"           {return new Symbol(ParserSym.INITPARAMETROS, yycolumn, yyline, yytext());}
"</parametros>"         {return new Symbol(ParserSym.ENDPARAMETROS, yycolumn, yyline, yytext());}
"<"                     {return new Symbol(ParserSym.MENORQUE, yycolumn, yyline, yytext());}
">"                     {return new Symbol(ParserSym.MAYORQUE, yycolumn, yyline, yytext());}
"["                     {return new Symbol(ParserSym.CORCHETEA, yycolumn, yyline, yytext());}
"]"                     {return new Symbol(ParserSym.CORCHETEC, yycolumn, yyline, yytext());}
{comillas}              {return new Symbol(ParserSym.COMILLAS, yycolumn, yyline, yytext());}

{spaceWhite}       {}

.   {JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la linea y columna " + yyline + " " + yycolumn +" en el token: " + yytext());}