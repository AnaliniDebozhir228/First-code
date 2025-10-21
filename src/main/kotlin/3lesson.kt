import jdk.jfr.DataAmount
import kotlin.random.Random

// class - ключевое слово
// character - имя классаю начинаються с большой буквы

class Character{
    var name: String = "Безымянный"
    var health: Int = 100
    val maxHealth: Int = 100
    var attack: Int = 15
    var isAlive: Boolean = true
    var mana: Int = 100
    val maxMana: Int = 100
    var magicAttack: Int = 25

    fun takeDamage(damage: Int){
        health -= damage
        println("$name получает $damage урона! HP: $health")

        if (this.health <= 0){
            isAlive = false
            println("$name  потрачено")
        }
    }

    fun heal(amount: Int){
        if (isAlive) {
            health = minOf(health + amount, maxHealth)
            println("$name востановил $amount HP. Actual HP: $health / $maxHealth")
        }else{
            println("$name alerdy die, and cant be healing")
        }
    }

    fun  attack(target: Character){
        if (!isAlive) {
            println("$name ты умер ты не можешь бить")
            return
        }else{
            val damage = calculateDamage(attack)
            println("$name attack ${target.name}")
            target.takeDamage(damage)
        }

    }
        fun  fireBall(target: Character){
            if (!isAlive) {
                println("$name ты умер ты не можешь бить")
                return
            }else{
                val damage = calculateDamage(magicAttack)
                println("$name attack ${target.name}")
                target.takeDamage(damage)
            }
            }
}

fun main(){
    println("=== создай алкаша")

    val player = Character()
    val enemy = Character()

    player.name = "Oleg"
    player.health = 100
    player.attack = 18
    player.magicAttack = 20
    player.mana = 100

    enemy.name = "Олег газманов"
    enemy.health = 20
    enemy.attack = 4

    println(">>> Fight <<<")
    player.attack(enemy)
    enemy.attack(player)

    println("\n --- Cactus ---")
    println("Player ${player.name} HP: ${player.health} / ${player.maxHealth} ${player.isAlive}")
    println("Player ${enemy.name} HP: ${enemy.health} / ${enemy.maxHealth} ${enemy.isAlive}")
    println("Player ${player.name} HP: ${player.health} / ${player.maxHealth} ${player.isAlive}")
    println("Player ${enemy.name} HP: ${enemy.health} / ${enemy.maxHealth} ${enemy.isAlive}")
}