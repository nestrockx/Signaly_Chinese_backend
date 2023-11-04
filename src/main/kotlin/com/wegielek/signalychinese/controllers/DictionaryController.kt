package com.wegielek.signalychinese.controllers

import com.wegielek.signalychinese.models.Dictionary
import com.wegielek.signalychinese.repo.DictionaryRepo
import com.wegielek.signalychinese.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DictionaryController {

    @Autowired
    private lateinit var repo: DictionaryRepo

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/getAll")
    fun getAll(): MutableIterable<Dictionary> {
        return repo.findAll()
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/getById/{index}")
    fun getById(@PathVariable index: Long): Optional<Dictionary> {
        return repo.findById(index)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/search/{searchQuery}")
    fun search(@PathVariable searchQuery: String): List<Dictionary> {
        val inputString: String = searchQuery.trim()
        return if (inputString.isNotEmpty()) {
            if (!Utils.containsChinese(inputString) && inputString.length > 1) {
                repo.searchByWordPL(inputString)
            } else {
                if (inputString.length == 1) {
                    repo.searchSingleCH(inputString)
                } else {
                    repo.searchByWordCH(inputString)
                }
            }
        } else {
            listOf()
        }
    }

}