<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <link href="index_style.css" rel="stylesheet">
    <meta charset="utf-8">
    <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <!----><script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>	-->
</head>
<body>

<nav class="navbar navbar-default">
    <div class="navbar-header">
        <a class="navbar-brand brand_nav" href="#">Notepads</a>
        <div class="col-md-4">
            <div class="input-group">
                <input type="text" class="form-control search_con" placeholder="Search for...">
						<span class="input-group-btn">
							<button class="btn btn-default search_con" type="button">Search!</button>
						</span>
            </div>
        </div>
        <label class="usr_nav">UserName</label>
        <button type="button" class="btn btn-primary btn_exit">Exit</button>
    </div>
</nav>

<!--Добавление блокнота-->
<div class="modal fade" id="smallModal_notepad" tabindex="-1" role="dialog" aria-labelledby="smallModal_notepad" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Add Notepad</h4>
            </div>
            <div class="form-group">
                <label for="name_notepad">Name</label>
                <input type="name_notepad" class="form-control" id="name_notepad" placeholder="Enter name">
                <p class="help-block">Enter the name of the notepad</p>
            </div>
            <div class="form-group">
                <label for="pass">Description</label>
                <textarea class="textarea2" id="redex" maxlength="100" rows="6" cols="40"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Add</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>

<!--Добавление Записи-->
<div class="modal fade" id="smallModal_record" tabindex="-1" role="dialog" aria-labelledby="smallModal_record" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Add Record</h4>
            </div>
            <div class="form-group">
                <label for="name_notepad">Name</label>
                <input type="name_notepad" class="form-control" id="name_notepad" placeholder="Enter name">
                <p class="help-block">Enter the name of the record</p>
            </div>
            <div class="form-group">
                <label for="pass">Description</label>
                <textarea class="textarea2" id="redex" maxlength="100" rows="6" cols="40"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Add</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-md-3 notepads">
            <button data-toggle="modal" data-target="#smallModal_notepad" type="button" class="btn btn-primary add_but_not"><span class="glyphicon glyphicon-plus"></span> Add</button>
            <button type="button" class="btn btn-primary del_but_not"><span class="glyphicon glyphicon-remove"></span> Delete</button>
        </div>
        <div class="col-md-3 records">
            <button data-toggle="modal" data-target="#smallModal_record" type="button" class="btn btn-success add_but_not"><span class="glyphicon glyphicon-plus"></span> Add</button>
            <button type="button" class="btn btn-success del_but_rec"><span class="glyphicon glyphicon-remove"></span> Delete</button>
        </div>
        <div class="col-md-6 contents">
            <form role="form_index">
                <div class="form-group">
                    <label class="name_record"for="name_record_index">Name</label>
                    <input type="name_record_index" class="form-control" id="name_record_index" placeholder="Enter name record">
                </div>
                <div class="form-group">
                    <label for="pass">Content</label>
                    <textarea class="textarea1" id="redex" maxlength="10000" rows="6" cols="62"></textarea>
                </div>
            </form>
            <label class="control-label">Select File</label>
            <input id="input-2" name="input2[]" type="file" class="file" multiple data-show-upload="false" data-show-preview="false" data-show-caption="true">

            <button type="button" class="btn btn-info cl_but_con"><span class="glyphicon glyphicon-saved"></span>Save</button>
            <button type="button" class="btn btn-info save_but_con"> Cancel</button>
        </div>
    </div>
</div>
</body>
</html>

<!--подключить необходимые библиотеки, которые зависят от интернета
-->

<!--
страница логина ~+
save ~+
верхний бар(выход, имя ....) ~+
стиль большого поля ввода ~+
добаление некольких файлов ~+
popup ~+
-->

<!--
сделать пару блоков в блокнотах и записях, по 2-3
сделать возможность добавлять несколько файлов: например, из разных папок
сделать нормальный попуп добавления записи
посмотреть зависимости и докачать файлы
-->


<!--
<div class="modal fade" id="smallModal" tabindex="-1" role="dialog" aria-labelledby="smallModal" aria-hidden="true">
<div class="modal-dialog modal-sm">
<div class="modal-content">
<div class="modal-header">
<h4 class="modal-title" id="myModalLabel">Small Modal</h4>
</div>
<div class="modal-body">
<h3>Modal Body</h3>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-primary">Save changes</button>
<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>
</div>
</div>
</div>

<button data-toggle="modal" data-target="#smallModal" type="button" class="btn btn-primary add_but_not"><span class="glyphicon glyphicon-plus"></span> Add</button>

<textarea class="form-control" rows="3"></textarea>
Badges
http://getbootstrap.com/components/#list-group-custom-content
--!>