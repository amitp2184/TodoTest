import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';
import { ActivatedRoute, Router } from '@angular/router';
import { WebServices } from 'src/app/webservice';
import { TodoModel } from 'src/app/todo.model';
import { Identifiers } from '@angular/compiler/src/render3/r3_identifiers';
import { TouchSequence } from 'selenium-webdriver';


@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  displayedColumns: string[] = ['select', 'title', 'description', 'date', 'actions'];
  todo: TodoModel[] = [];
  private id: any;
  dataSource = new MatTableDataSource<TodoModel>(this.todo);
  selection = new SelectionModel<TodoModel>(true, []);
  private context: any = {};
  private ids: any[] = new Array;

  constructor(private router: ActivatedRoute,
    private route: Router,
    private service: WebServices
  ) {

  }

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.getTodoList();
  }

  getTodoList() {

    this.service.getList().subscribe((res: TodoModel[]) => {
      this.dataSource = new MatTableDataSource(res);

      // this.dataSource = response.json().data;
      this.dataSource.paginator = this.paginator;
      // console.log(res.json().data);
    });
  }

  /**this is for navigate to next page*/
  addTodo() {
    this.route.navigate(['/add-todo']);
  }

  /**this is delete todo*/
  deleteTodo(row) {
    this.service.deleteTodo(row.todoSeqId).subscribe((res: any) => {
      this.ngOnInit();
    });
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

masterToggle() {
this.isAllSelected() ?
this.selection.clear() :
this.dataSource.data.forEach(row => this.selection.select(row));
}

checkboxLabel(row?: TodoModel): string {
if (!row) {
return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
}
return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
}

/**add id to array list*/
addRemoveIdToList(row) {
if (!this.selection.isSelected(row)) {
this.ids.push(row.todoSeqId);     //checkbox selection
} else {
this.ids.splice(this.ids.indexOf(row.todoSeqId), 1);
}
}

/** delete todo*/
deleteChecked() {
this.context = {
"ids": this.ids
}
this.service.deleteAllTodo(this.context).subscribe((res: any) => {
this.ngOnInit();
})

}
    /** navigate to list page*/

     updateTodo(row){
      this.route.navigate(['/update-todo/'+row.todoSeqId]);
     }

}
