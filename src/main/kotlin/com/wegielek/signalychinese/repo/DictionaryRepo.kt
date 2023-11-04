package com.wegielek.signalychinese.repo

import com.wegielek.signalychinese.models.Dictionary
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DictionaryRepo: CrudRepository<Dictionary, Long> {

    @Query(value = "SELECT * FROM dictionary WHERE traditional_sign LIKE :searchQuery || '%' OR simplified_sign LIKE :searchQuery || '%' ORDER BY LENGTH(traditional_sign) ASC", nativeQuery = true)
    fun searchByWordCH(@Param("searchQuery") searchQuery: String) : List<Dictionary>

    @Query(value = "SELECT * FROM dictionary WHERE traditional_sign = :searchQuery OR simplified_sign = :searchQuery ORDER BY LENGTH(traditional_sign) ASC", nativeQuery = true)
    fun searchSingleCH(@Param("searchQuery") searchQuery: String) : List<Dictionary>

    @Query(value = "SELECT * FROM dictionary WHERE lower(translation) LIKE lower(:searchQuery) || ' %' OR lower(translation) LIKE '%/ ' || lower(:searchQuery) || ' %' OR lower(translation) LIKE '%) ' || lower(:searchQuery) || ' %' OR lower(translation) LIKE '%. ' || lower(:searchQuery) || ' %' OR lower(pronunciation_phonetic) LIKE lower(:searchQuery) || ' %' OR lower(pronunciation) LIKE lower(:searchQuery) || ' %' ORDER BY LENGTH(traditional_sign) ASC", nativeQuery = true)
    fun searchByWordPL(@Param("searchQuery") searchQuery: String) : List<Dictionary>


}