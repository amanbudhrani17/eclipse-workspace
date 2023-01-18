import 'package:flutter/material.dart';
void main(){
  runApp(MyApp());
}
class MyApp extends StatelessWidget{
  Widget build(BuildContext context){
    return MaterialApp(
        home: Scaffold(
          backgroundColor: Colors.black,
        appBar: AppBar(
          title: Text("Quiz App"),
          backgroundColor: Colors.black,
        ),
        body: const Center ( 
          child: Image(
            image: NetworkImage("https://wallpapercave.com/wp/wp2694156.jpg"), fit: BoxFit.fitWidth,
          ),
        ),
        floatingActionButton: FloatingActionButton(

          onPressed: () {  },
          child: Text("click"),
          backgroundColor: Colors.black,
        ),
        )
    );
  }
}