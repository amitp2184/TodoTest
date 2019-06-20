import { environment as ENV } from '../environments/environment'
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

let URLS = {

getList : ENV.BASE_URL + 'get/all',
addTodo: ENV.BASE_URL + 'create',
deleteTodo: ENV.BASE_URL + 'delete/by/',
deleteAllTodo: ENV.BASE_URL + 'delete/all',
updateTodo: ENV.BASE_URL + 'update',
getTodoById: ENV.BASE_URL + 'get/by/'
}

let headerOptions = {
headers: {
'Content-Type': 'application/json'
}
};


@Injectable()
export class WebServices{

constructor(private http: HttpClient) {}

/** get all data */
getList(){ 
return this.http.get(URLS.getList);
}

/** create todo */
addTodo(object){
return this.http.post(URLS.addTodo, JSON.stringify(object), headerOptions);
}

/** delete todo*/
deleteTodo(id) {
return this.http.delete(URLS.deleteTodo + id, headerOptions);
}

/**this is delete all todo*/
deleteAllTodo(object){
return this.http.post(URLS.deleteAllTodo, JSON.stringify(object),headerOptions);
}

updateTodo(object){ 
   return this.http.put(URLS.updateTodo, JSON.stringify(object) ,headerOptions);

}

getTodoById(id){

   return this.http.get(URLS.getTodoById+id);

}
}