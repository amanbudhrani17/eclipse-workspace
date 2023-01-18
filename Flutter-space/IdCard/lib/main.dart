import 'package:flutter/material.dart';

void main() {
 runApp(MyApp());
}
class MyApp extends StatelessWidget{
 Widget build(BuildContext context){
  return MaterialApp(
   home: Scaffold(
    backgroundColor: Colors.grey[900],
    appBar: AppBar(
     title: Text("IIITG ID Card"),
     backgroundColor: Colors.grey[850],
    ),
    body: Padding(
     padding: EdgeInsets.fromLTRB(30, 40, 30, 0),
     child: Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
       Center(
        child: CircleAvatar(
         backgroundImage: AssetImage("assets/naruto2.png",),
         radius: 100,
        ),
       ),

       Text("Name",
        style: TextStyle(
         color: Colors.grey,
         letterSpacing: 2.0,

        ),
       ),
       SizedBox(height: 10.0),
       Text("Aman Budhrani",
        style: TextStyle(
         color: Colors.amberAccent,
         letterSpacing: 2.0,
         fontSize: 28.0,
         fontWeight: FontWeight.bold
        ),
       ),
       SizedBox(height: 30,),
       Text("Semester",
        style: TextStyle(
         color: Colors.grey,
         letterSpacing: 2.0,

        ),
       ),
       SizedBox(height: 10.0),
       Text("5th",
        style: TextStyle(
            color: Colors.amberAccent,
            letterSpacing: 2.0,
            fontSize: 28.0,
            fontWeight: FontWeight.bold
        ),
       ),
       SizedBox(height: 30,),
       Row(
        children: <Widget>[
         Icon(Icons.email,
          color: Colors.grey,
          
         ),
         Text(" aman.budhrani@iiitg.ac.in",
         style: TextStyle(
          color: Colors.grey[400],
          fontSize: 18.0,
          letterSpacing: 1.0,
         ),
         ),
        ],
       ),
       SizedBox(height: 30,),
       Row(
        children: <Widget>[
         Icon(Icons.phone,
          color: Colors.grey,

         ),
         Text(" +91 964-444-7030",
          style: TextStyle(
           color: Colors.grey[400],
           fontSize: 18.0,
           letterSpacing: 1.0,
          ),
         ),
        ],
       )
      ],
     ),
    ),
   ),
  );
 }
}

