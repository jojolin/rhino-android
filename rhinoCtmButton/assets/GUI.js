/**
 * Created by JOJO.
 * this file:
 *   create the main UI for the android activity.
 *
 */

/** set up the env from the Package.ctm.widgets */
/** using " Packages.android.widget.* " can not work */
var GUI = JavaImporter(Packages.com.example.rhinoCtmButton,
                       Packages.android.widget.Button,
                       Packages.android.widget.LinearLayout,
                       Packages.android.widget.TextView,
                       Packages.android.content.Context);

/** also okay bellow */
//GUI.importPackage(Packages.ctm.widgets);

/** example-1 */
// simple button
function createComponents()
{
  with (GUI) {
    var btn=new CtmClass("JButton");
    return btn.getLabel();
  }
}

/** example-2 */
// linear layout
function CreateGUI(){

  with(GUI){
    // get ContextApplication from Packages.com.example.rhinoCtmButton
    // this ContextApplication will be used as the global "context" for the widgets.
    var contextApplication=ContextApplication.Init();
    // linearGUI will be return as the main UI in "android activity"
    var linearGUI = new LinearLayout(contextApplication);
    linearGUI.setOrientation(LinearLayout.VERTICAL);

    /** for test */
    //        var btn=new Button(contextApplication);
    //        btn.setText("this button is from js btn");
    //        btn.setOnClickListener(function(view){
    //                var i = 0  , dt = new Date , s =  0 ;
    //
    ////                for( i = 0 ; i < 100000; i ++ ){
    ////                    btn.setText("click me! " + dt );
    ////                }
    ////                dt = new Date - dt ;
    //                btn.setText("click me! " + dt );
    //            }
    //        );
    //
    //        linearGUI.addView(btn);

    var num=0;
    function makeItem(){

      var linearItem = new LinearLayout(contextApplication);
      linearItem.setOrientation(LinearLayout.HORIZONTAL);

      var tv=new TextView(contextApplication);
      tv.setText("textView: "+ num);

      var btn=new Button(contextApplication);
      btn.setText("button:"+num);
      btn.setOnClickListener(function(view){
        var dt = new Date;
        btn.setText("click me! " + dt );
      });

//      btn.setX(100.0);

        /** !! setX and setY require SDK 11 */
//      var btn_main = new Button(contextApplication);
//      btn_main.setText("btn main");
//      btn_main.setX(0.0);
//      btn_main.setY(100.0);

      linearItem.addView(tv);
      linearItem.addView(btn);
//      linearItem.addView(btn_main);


      return linearItem;
    }

    for(num=0;num<50;num++){
      var ll=makeItem();
      linearGUI.addView(ll);
    }

    return linearGUI;
  }
}