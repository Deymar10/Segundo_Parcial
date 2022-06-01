package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAOimpl extends ConexionDB implements SeminarioDAO {

    @Override
    public void insert(Seminario seminario) throws Exception {
        try {
            String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
            this.conectar();
            PreparedStatement ps = (PreparedStatement) this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());            
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        try {
            String sql = "update seminarios set titulo=?, fecha=? , cupo=? where id=?";
            this.conectar();
            PreparedStatement ps = (PreparedStatement) this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());            
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupo());
            ps.setInt(4, seminario.getId());
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
            String sql = "delete from seminarios where id=?";
            this.conectar();
            PreparedStatement ps = (PreparedStatement) this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario pro = new Seminario();
        try {
            this.conectar();
            PreparedStatement ps = (PreparedStatement) this.conn.prepareStatement("select * from seminarios where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setTitulo(rs.getString("titulo"));
                pro.setFecha(rs.getDate("fecha"));
                pro.setCupo(rs.getInt("cupo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List<Seminario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from seminarios");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Seminario>();
            while (rs.next()) {
                Seminario pro = new Seminario();

                pro.setId(rs.getInt("id"));
                pro.setTitulo(rs.getString("titulo"));
                pro.setFecha(rs.getDate("fecha"));
                pro.setCupo(rs.getInt("cupo"));

                lista.add(pro);
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
