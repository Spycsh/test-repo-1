# Preliminary Report

![](proj_struct.PNG)

Firstly we should specify the structure of the project. As shown in the graph, there are five components which communicate with each other to 

With the preliminary template given, the project is planned to be done in following steps:


## 1 implement lookup, namely GET(key) and PUT(key, value)

Given the structure and the previous tutorials. To implement GET and PUT functions, we must in `clientService.scala` of the client folder implement the GET and PUT functions and call trigger onself function to let the message to be routed to the server service. The server has the mission to lookup or put the key-value pair in the corresponding place. Also, a case class should be defined in th common folder in the `Operation.scala`. Next, when we move to the server folder, we can deal with the requests by specifying the PUT or GET operation in parallel with the default "Op" operation in `KVStore.scala`. Finally, the `VSOverlayManager` will deal with the operations and lookup using the `LookupTable` class. 



