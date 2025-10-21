import kotlin.random.Random

fun calculateDamage(baseAttack: Int): Int{
    val variation = Random.nextInt(80, 121)
    return  (baseAttack * variation) / 100
}

fun performAttack(attackerName: String, attackerAttack: Int, defenderName: String, defenderHealth: Int): Int{
    println("Ход: $attackerName")
    val damage = calculateDamage(attackerAttack)
    var newHealth = defenderHealth - damage

    println("$attackerName attack $defenderName with $damage damage")
    println("$defenderName HP: $newHealth")

    return  newHealth
}

fun startBattle(){
    val playerName: String = "Олег Апосум"
    var playerHealth: Int = 100
    var playerAttack: Int = 18

    val enemyName: String = "Егор Горлочист"
    var enemyHealth: Int = 100
    val enemyAttack = 12

    println("БоеЦ БЕЛЫХ ОЗЁР: $playerName (HP: $playerHealth ATK: $playerAttack")
    println("БоеЦ ABSOLUT VODKA: $enemyAttack (HP: $enemyHealth ATK: $enemyAttack Attack")

    var round = 1

    while (playerHealth > 0 && enemyHealth > 0) {
        println("\n--- Round $round ---")

        enemyHealth = performAttack(playerName, playerAttack, enemyName, enemyHealth)

        if (enemyHealth <= 0) break

        playerHealth = performAttack(enemyName, enemyAttack, playerName, playerHealth)

        round++
    }
    println("\n=== Бой окончен ===")
    if (playerHealth > 0){
        println("Ты победил, выпей чакушку")
    }else{
        println("Ты проиграл, сегодня без чакушки")
    }

}

fun main(){
    println("=== Бой бомжей за чакушку ===")
    startBattle()
    println("=== Бой окончен")
}


