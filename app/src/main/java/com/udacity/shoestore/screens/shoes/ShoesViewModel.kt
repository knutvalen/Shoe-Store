package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

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
            )
        )
    }

}