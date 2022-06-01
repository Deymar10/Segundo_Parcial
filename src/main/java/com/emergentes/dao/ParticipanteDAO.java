package com.emergentes.dao;

import com.emergentes.modelo.Participante;
import java.util.List;

public interface ParticipanteDAO {
    public void insert(Participante participante) throws Exception;
    public void update(Participante participante) throws Exception;
    public void delete(int id) throws Exception;
    public Participante getById(int id)throws Exception;
    public List<Participante> getAll()throws Exception;
}
