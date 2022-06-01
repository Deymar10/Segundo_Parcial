package com.emergentes.dao;

import com.emergentes.modelo.Participante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAOimpl extends ConexionDB implements ParticipanteDAO {

    @Override
    public void insert(Participante cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into participantes (apellidos,nombres,id_seminario,confirmado) values (?,?,?,?)");
            ps.setString(2, cliente.getApellidos());
            ps.setString(1, cliente.getNombres());
            ps.setString(3, cliente.getId_seminario());
            ps.setString(4, cliente.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Participante cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update participantes set apellidos=?, nombres=? , id_seminario=?, confirmado=? where id=?");
            ps.setString(2, cliente.getApellidos());
            ps.setString(1, cliente.getNombres());
            ps.setString(3, cliente.getId_seminario());
            ps.setString(4, cliente.getConfirmado());
            ps.setInt(5, cliente.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from participantes where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Participante getById(int id) throws Exception {
        Participante cli = new Participante();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from participantes where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setNombres(rs.getString("nombres"));
                cli.setId_seminario(rs.getString("id_seminario"));
                cli.setConfirmado(rs.getString("confirmado"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Participante> getAll() throws Exception {
        List<Participante> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from participantes");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Participante>();
            while (rs.next()) {
                Participante cli = new Participante();
                cli.setId(rs.getInt("id"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setId_seminario(rs.getString("id_seminario"));
                cli.setConfirmado(rs.getString("confirmado"));

                lista.add(cli);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
