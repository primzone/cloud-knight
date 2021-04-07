<div class="card" style="width: 18rem;">
    <img src="https://cdn1.flamp.ru/57e7537931d9746d932cd10983eb4e68.jpg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Имя: ${knight.name}</h5>
        <h6 class="card-title">Город: ${knight.fromCity}</h6>
        <p class="card-text">Великий воин из далеких краев</p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item"><b>Здоровье: </b>${knight.hp}</li>
        <li class="list-group-item"><b>Сила атаки: </b>${knight.str}</li>
        <li class="list-group-item"><b>Защита: </b>${knight.def}</li>
        <li class="list-group-item"><b>Уровень: </b>${knight.level}</li>
        <li class="list-group-item"><b>Убито монстров: </b>${knight.killedMonsters}</li>

    </ul>
    <div class="card-body">
        <a href="#" class="card-link">Ссылка карточки</a>
        <a href="#" class="card-link">Другая ссылка</a>
    </div>
</div>