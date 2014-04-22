/**
 * var ScriptAPI = java.lang.Class.forName("hello.rhino.JavaClassProvider");
 * this can not work
 */

/** get the class name: "hello.rhino.JavaClassProvider" */
//var ScriptAPI = java.lang.Class.forName("com.example.ctm.widgets.CtmClass",false,CtmClassLoader);

var GUI = JavaImporter(Packages.com.example.ctm.widgets,
                       Packages.com.example.rhinoCtmButton);

var ScriptAPI = java.lang.Class.forName("com.example.rhinoCtmButton.ContextActivity",true,ContextActivityLoader);

/*var mCtmClass=new ScriptAPI("From JS label")*/
// todo: make the call procedure clear
/** get the method name: "jsCallJava" */
var methodRead = ScriptAPI.getMethod("outPutStr");
/** invoke method */
function jsCallJava() {
  return methodRead.invoke(null);
}
// js function: Test()
function Test(){
  return jsCallJava();
  /** also ok bellow */
//  return methodRead.invoke(null,"** JS CALL YOU **");
}

