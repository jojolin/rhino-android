/**
 * var ScriptAPI = java.lang.Class.forName("hello.rhino.JavaClassProvider");
 * this can not work
 */

/** get the class name: "hello.rhino.JavaClassProvider" */
var ScriptAPI = java.lang.Class.forName("com.example.rhinoCtmButton.JavaClassProvider",true,javaClassProviderLoader);

// todo: make the call procedure clear
/** get the method name: "jsCallJava" */
var methodRead = ScriptAPI.getMethod("jsCallJava", [java.lang.String]);
/** invoke method */
function jsCallJava(url) {
  return methodRead.invoke(null, url);
}
// js function: Test()
function Test(){
  return jsCallJava("** JS CALL YOU **");
  /** also ok bellow */
//  return methodRead.invoke(null,"** JS CALL YOU **");
}
