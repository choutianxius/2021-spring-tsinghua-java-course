package com.choutianxius.javaengineering.libraryassistant.inmemory;

import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;
import com.choutianxius.javaengineering.libraryassistant.core.Assistant;
import com.choutianxius.javaengineering.libraryassistant.core.AssistantService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用内存存储方式实现 {@link AssistantService}
 *
 * @author octopusthu@gmail.com
 */
@Service
//@Qualifier("InMemoryAssistantServiceImpl")
public class InMemoryAssistantServiceImpl implements AssistantService {
    private final Map<Integer, Assistant> assistants = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void createAssistant(Integer id, String name, String phone) throws DomainObjectException {
        if (assistants.get(id) != null) {
            throw new DomainObjectException("duplicate id: " + id);
        }
        try {
           assistants.put(id, new Assistant(id, name, phone));
        } catch (IllegalArgumentException e) {
            throw new DomainObjectException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAssistant(Integer id) throws DomainObjectException {
        if(id == null) {
            throw new DomainObjectException("ID can't be null");
        }
        assistants.remove(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Assistant getAssistant(Integer id) throws DomainObjectException {
        if(id == null) {
            throw new DomainObjectException("ID can't be null");
        }
        return assistants.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Assistant> getAllAssistants() {
        return List.copyOf(assistants.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPhone(Integer id) {return assistants.get(id).getPhone();}
}
