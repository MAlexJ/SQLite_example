package com.malexj.app.service.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.ConsoleDao;
import com.malexj.app.service.ConsoleService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (query.startsWith("SELECT"))
        {
            return consoleDao.executeSelect(query);
        }

        if (query.startsWith("INSERT") || query.startsWith("UPDATE") || query.startsWith("DELETE") || query.startsWith("CREATE"))
        {
            return consoleDao.executeUpdate(query);
        }

        return BuilderDTO.builder()
                .message("Successful: " + query)
                .build();
    }
}
