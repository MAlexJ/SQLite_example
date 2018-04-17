package com.malexj.app.repository;

import com.malexj.app.dto.BuilderDTO;

public interface ConsoleDao
{
    BuilderDTO executeSelect(String query);

    BuilderDTO executeUpdate(String query);
}
