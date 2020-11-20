package com.udacity.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private val _eventAdd = MutableLiveData<Boolean>()
    val eventAdd: LiveData<Boolean>
        get() = _eventAdd

    init {
        _shoes.value = mutableListOf(
            Shoe(
                "Superstar",
                44.0,
                "Adidas",
                "THE AUTHENTIC LOW TOP WITH THE SHELL TOE.\n" +
                    "\n" +
                    "Originally made for basketball courts in the '70s. Celebrated by hip hop " +
                        "royalty in the '80s. The adidas Superstar shoe is now a lifestyle staple " +
                        "for streetwear enthusiasts. The world-famous shell toe feature remains, " +
                        "providing style and protection. Just like it did on the B-ball courts back " +
                        "in the day. Now, whether at a festival or walking in the street you can " +
                        "enjoy yourself without the fear of being stepped on. The serrated 3-Stripes " +
                        "detail and adidas Superstar box logo adds OG authenticity to your look."
            ),
            Shoe(
                "Ultraboost",
                44.0,
                "Adidas",
                "RESPONSIVE SHOES MADE FOR LONG RUNS ON CITY STREETS.\n" +
                        "\n" +
                        "Get that best-ever feeling on every run. These neutral shoes have a " +
                        "stretchy knit upper with ventilation in key sweat zones to help you stay " +
                        "cool. Energy-returning cushioning and a flexible outsole work together to " +
                        "give you a smooth ride from touch-down to toe-off."
            ),
            Shoe(
                "Air Force 1 '07",
                44.0,
                "Nike",
                "The Nike Air Force 1 '07 is the b-ball legend you know best: crisp " +
                        "leather, bold colours and the perfect amount of flash to make you shine. " +
                        "Holographic Swooshes on selected colourways will keep you turning heads " +
                        "from sunrise to sunset."
            ),
        )


    }

    fun onAdd() {
        _eventAdd.value = true
    }

    fun onAddComplete() {
        _eventAdd.value = false
    }

    fun onAddShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }

}