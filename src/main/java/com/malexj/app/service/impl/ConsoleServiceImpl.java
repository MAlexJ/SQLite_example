package com.malexj.app.service.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.ConsoleDao;
import com.malexj.app.service.ConsoleService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.malexj.app.constant.Constant.SELECT_QUERY;
import static com.malexj.app.constant.Constant.SQL_QUERY_END;

@Service
public class ConsoleServiceImpl implements ConsoleService
{
    private final ConsoleDao consoleDao;

    @Autowired
    public ConsoleServiceImpl(ConsoleDao consoleDao)
    {
        this.consoleDao = consoleDao;
    }

    @Override
    public BuilderDTO executeQuery(@NonNull String query)
    {
        String trimQuery = query.trim();
        if (!query.trim().endsWith(";"))
        {
            return BuilderDTO.builder()
                    .isError(true)
                    .message(SQL_QUERY_END)
                    .build();
        }
        String toUpperCaseQuery = trimQuery.toUpperCase();
        if (toUpperCaseQuery.startsWith(SELECT_QUERY))
        {
            return consoleDao.executeSelect(query);
        }
        return consoleDao.executeUpdate(query);
    }
}
