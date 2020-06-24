/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.con_imc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.model_pessoa;

/**
 *
 * @author Debora Freire
 */
public class dao_imc {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public dao_imc() {
        con = con_imc.getConnection();

    }

    //insert 
    public void cadastraPessoa(model_pessoa pessoa) {
        try {
            ps = con.prepareStatement("INSERT INTO dados(peso,altura)values(?,?)");
            ps.setFloat(1, pessoa.getPeso());
            ps.setFloat(2, pessoa.getAltura());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Os dados foram inseridos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        } finally {
            con_imc.closeConnection(con, ps);
        }
    }

    //select
    public List<model_pessoa> mostraDados() {
        String sql = "";
        List<model_pessoa> lstPessoa = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_pessoa pessoa = new model_pessoa();
                pessoa.setAltura(rs.getFloat("altura"));
                pessoa.setPeso(rs.getFloat("peso"));
                pessoa.setImc(rs.getFloat("imc"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        } finally {
            con_imc.closeConnection(con, ps, rs);

        }
        return lstPessoa;
    }

}
