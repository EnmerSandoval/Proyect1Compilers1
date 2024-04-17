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
COLOR_HEX = "#"([0-9a-fA-F]{6})
IDENTIFICADOR = [^\[\n\r]*;

%eofval{
    return new Symbol(ParserSym.EOF);
%eofval}



%%


//Reserved Words
"NUEVO_SITIO_WEB"       {return new Symbol(ParserSym.NUEVO_SITIO_WEB, yycolumn, yyline, yytext());}
"ID"                    {return new Symbol(ParserSym.ID, yycolumn, yyline, yytext());}
"USUARIO_CREACION"      {return new Symbol(ParserSym.USUARIO_CREACION, yycolumn, yyline, yytext());}
"FECHA_CREACION"        {return new Symbol(ParserSym.FECHA_CREACION, yycolumn, yyline, yytext());}
"FECHA_MODIFICACION"    {return new Symbol(ParserSym.FECHA_MODIFICACION, yycolumn, yyline, yytext());}
"USUARIO_MODIFICACION"  {return new Symbol(ParserSym.USUARIO_MODIFICACION, yycolumn, yyline, yytext());}
"BORRAR_SITIO_WEB"      {return new Symbol(ParserSym.BORRAR_SITIO_WEB, yycolumn, yyline, yytext());}
"NUEVA_PAGINA"          {return new Symbol(ParserSym.NUEVA_PAGINA, yycolumn, yyline, yytext());}
"TITULO"                {return new Symbol(ParserSym.TITULO, yycolumn, yyline, yytext());}
"PARRAFO"               {return new Symbol(ParserSym.PARRAFO, yycolumn, yyline, yytext());}
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
"TEXTO"                 {return new Symbol(ParserSym.TEXTO, yycolumn, yyline, yytext());}
"COLOR"                 {return new Symbol(ParserSym.COLOR, yycolumn, yyline, yytext());}
"nombre"                {return new Symbol(ParserSym.NOMBRE, yycolumn, yyline, yytext());}
"valor"                 {return new Symbol(ParserSym.VALOR, yycolumn, yyline, yytext());}

//Labels reserved
"<atributo"             {return new Symbol(ParserSym.INITATRIBUT, yycolumn, yyline, yytext());}
"</atributo>"           {return new Symbol(ParserSym.ENDATRIBUT, yycolumn, yyline, yytext());}
"<atributos>"           {return new Symbol(ParserSym.INITATRIBUTOS, yycolumn, yyline, yytext());}
"</atributos>"          {return new Symbol(ParserSym.ENDATRIBUTOS, yycolumn, yyline, yytext());}
"<accion"               {return new Symbol(ParserSym.INITACCION, yycolumn, yyline, yytext());}
"</accion>"             {return new Symbol(ParserSym.ENDACCION, yycolumn, yyline, yytext());}
"<acciones>"            {return new Symbol(ParserSym.INITACCIONES, yycolumn, yyline, yytext());}
"</acciones>"           {return new Symbol(ParserSym.ENDACCIONES, yycolumn, yyline, yytext());}
"<parametro"            {return new Symbol(ParserSym.INITPARAMETRO, yycolumn, yyline, yytext());}
"</parametro>"          {return new Symbol(ParserSym.ENDPARAMETRO, yycolumn, yyline, yytext());}
"<parametros>"          {return new Symbol(ParserSym.INITPARAMETROS, yycolumn, yyline, yytext());}
"</parametros>"         {return new Symbol(ParserSym.ENDPARAMETROS, yycolumn, yyline, yytext());}
"<etiqueta"             {return new Symbol(ParserSym.INITETIQUETA, yycolumn, yyline, yytext());}
"</etiqueta>"           {return new Symbol(ParserSym.ENDETIQUETA, yycolumn, yyline, yytext());}
"<etiquetas>"           {return new Symbol(ParserSym.INITETIQUETAS, yycolumn, yyline, yytext());}
"</etiquetas>"          {return new Symbol(ParserSym.ENDETIQUETAS, yycolumn, yyline, yytext());}

//Signs reserved
"="                     {return new Symbol(ParserSym.IGUAL, yycolumn, yyline, yytext());}
"<"                     {return new Symbol(ParserSym.MENORQUE, yycolumn, yyline, yytext());}
">"                     {return new Symbol(ParserSym.MAYORQUE, yycolumn, yyline, yytext());}
"["                     {return new Symbol(ParserSym.CORCHETEA, yycolumn, yyline, yytext());}
"]"                     {return new Symbol(ParserSym.CORCHETEC, yycolumn, yyline, yytext());}

//regex
{comillas}              {return new Symbol(ParserSym.COMILLAS, yycolumn, yyline, yytext());}
{COLOR_HEX}             {return new Symbol(ParserSym.HEXADECIMAL, yycolumn, yyline, yytext());}
{IDENTIFICADOR}         {return new Symbol(ParserSym.IDENTIFICADOR, yycolumn, yyline, yytext());}
{spaceWhite}       {}

//Error
.   {JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la linea y columna " + yyline + " " + yycolumn +" en el token: " + yytext());}