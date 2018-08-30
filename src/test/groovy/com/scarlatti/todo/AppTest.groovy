package com.scarlatti.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 6/9/2018
 */
@SpringBootTest
class AppTest extends Specification {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate

    @Autowired
    JdbcTemplate jdbcTemplate

    def "add a couple todos"() {
        expect:
            namedParameterJdbcTemplate.update("insert into TODO (text, completed_ind) values(:text, :completedInd)", [
                    text: "hey!",
                    completedInd: "N"
            ])
    }

    def "update todo 1"() {
        expect:
            jdbcTemplate.update("update todo set completed_ind='Y' where id=1")
    }
}
