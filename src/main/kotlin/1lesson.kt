import kotlin.random.Random
fun main(){
    println("Та заебали, каждый раз хеллоу форлд писать")
    println("Иди нахуй уже")
    var  playerName: String = "Олег"
    val maxHealth: Int = 100

    var currentHealth: Int = 100

    var playerAttack: Int = 15

    var isAlive: Boolean = true

    var gold: Int = 50

    println("Игрок $playerName идёт нахуй")
    println("Здоровье: $currentHealth / $maxHealth")
    println("Всего монет: $gold")
    println("Он жив? Ответ: $isAlive")

    println("\n >>> $playerName наступил в говно <<<")


    val trapDamage: Int = 35
    currentHealth -= trapDamage

    if(currentHealth <= 0){
        isAlive = false
        println("$playerName сдох как лох ебанный")
    }else{
        println("$playerName как ты сука выжил?!?!")
    }

    val damageVariation = Random.nextInt(80,121)

    val actualDamage = (playerAttack * damageVariation) / 100

    val monsterName: String = "Тун тун тун пиздун"
    var monsterHealth: Int = 50
    var monsterAttack: Int = 12

    monsterHealth -= actualDamage
    println("$playerName дал пизды $monsterName в размере $actualDamage")
    if (monsterHealth <= 10){
        println("$monsterName сдох обосанным")
    }else{
        println("$monsterName получил пизды, но остался в бою с $monsterHealth здоровья")
    }
    currentHealth -= monsterAttack
    isAlive = currentHealth > 0
    if(!isAlive){
        println("$monsterName отхуярил $playerName")
    }else{
        println("$playerName получает пизды от $monsterName в размере $monsterAttack \n Осталось $currentHealth здоровье")
    }
}