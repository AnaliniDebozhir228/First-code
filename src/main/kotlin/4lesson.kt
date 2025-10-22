import kotlin.random.Random

class Character(var name: String, var health: Int, var attack: Int){
    val maxHealth: Int = 100
    var isAlive: Boolean = true
    var shield: Boolean = false

    fun takeDamage(damage: Int){
        if (shield == true){
            health -= (damage/2)
            println("player $name resistence x2 damage. And take ${damage/2}  damage")
        }else{
            health -= damage
            println("Player $name take $damage damage")
        }

        if (health <= 0){
            isAlive = false
            println("Player $name ded inside")
        }
    }

    fun attack(target: Character){
        if (isAlive = false){
            println("U ded inside")
            return
        }

        println("$name beat ${target.name}")
        val damage = calculateDamage(attack)
        target.takeDamage(attack)
    }

    fun heal(amount: Int){
        if (!isAlive) return

        health = minOf((health+amount), maxHealth)
        println("Player $name healing by $amount. HP: $health / $maxHealth")
    }
}

class Item(
    val id: String,
    val name: String,
    val description: String,
    val value: Int = 0,
    val useEffect: (Player) -> Unit = {}
){
    fun use(player: Player){
        println("Used $name")
        useEffect(player )
    }
    fun displayInfo(){
        println("$name - $description (Cost: $value)")
    }
}

class Inventory {
    private val items = mutableListOf<Item>()
    fun addItem(item: Item){
        items.add(item)
        println("Item ${item.name} added to inventore")
    }

    fun removeItem(index: Int): Boolean{
        if (index in 0 until items.size){
            val removeItem = items.removeAt(index)
            println("Iten ${removeItem.name} delete from inventory")
            return true
        }
        println("Items dont exists")
        return false
    }

    fun useItem(index: Int, player: Player): Boolean{
        if (index in 0 until items.size){
            val item = items[index]

            item.use(player)
        }
    }
}
