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
    var mana: Int = 50
    val maxMana: Int = 50
    var magicAttack: Int = 25
    var shield: Boolean = false

    fun takeDamage(damage: Int){
        if (shield){
            health -=(damage/2)
            println("$name take $damage HP: $health")
            shield = false
        }else{
            health -= damage
                println("$name получает $damage урона! HP: $health")
        }


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
            if (!isAlive && mana >= 4) {
                println("$name ты умер ты не можешь бить")
                return
            }else{
                val damage = calculateDamage(magicAttack)
                println("$name attack ${target.name}")
                target.takeDamage(damage)
                mana -= 5
            }
        }

}

class item(val id: String,val name: String, val discriptopn: String, var cost: Int){
    fun effect(player: Character){
        if (id == "heal_poition"){
            player.heal(25)
        }else if (id == "mana_poition"){
            println("${player.name} healed 25 HP")
            player.mana = minOf(player.mana + 10, player.maxMana)
            player.mana += 10
       }
    }
    fun shield(player: Character){
        player.shield = true
        println("${player.name} take up the shield")
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
    enemy.health = 100
    enemy.attack = 4

    println(">>> Fight <<<")
    player.fireBall(enemy)
    enemy.attack(player)

    println("\n --- Cactus ---")
    println("Player ${player.name} HP: ${player.health} / ${player.maxHealth} ${player.isAlive} Mana: ${player.mana}")
    println("Player ${enemy.name} HP: ${enemy.health} / ${enemy.maxHealth} ${enemy.isAlive}")

    val healPotion = item ("heal_potion", "Heal Potion", "healing you by 25HP", 25)
    val manaPotion = item ("mana_potion", "Mana Potion", "Recover 10 mana", 25)
    val shield = item("shield", "Shield", "defend damage", 60)

    shield.shield(player)
    player.fireBall(enemy)
    enemy.attack(player)
}


