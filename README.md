<div>

<h1 align="center"> Описание консольного приложения "Students" с использованием стартера SpringShell</h1>

<h2> Описание команд:</h2>
<ul>
  <li> list - вывод списка студентов</li>
  <li> add <Имя> <Фамилия> <Возраст> - добавление информации о студенте в список</li>
  <li> clear_list - очистка списка студентов</li>
  <li> delete &lt;id&gt; - удаление студента по id</li>
</ul>
<br>
<h2> Настройки: </h2>
 <ul>
  <li> В файле application.properties переменная app.start_values.enabled (true/false) отвечает за создание записей о студентах после старта</li>
</ul>
 <h2> Запуск: </h2>   
 <ul>
  <li> Для создания докер-контейнера используется команда: docker build -t students .</li>
  <li> Для запуска докер-контейнера используется команда: docker run -it --rm students</li>
</ul>
</div> 
