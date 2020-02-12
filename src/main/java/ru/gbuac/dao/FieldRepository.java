package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Field;

@Transactional(readOnly = true)
public interface FieldRepository extends JpaRepository<Field, Integer> {
}
