package teoria;

import examenBase.ArrayList;
import examenBase.Connection;
import examenBase.List;
import examenBase.Medico;
import examenBase.Paciente;
import examenBase.PreparedStatement;
import examenBase.ResultSet;
import examenBase.SQLException;

public class New {

	public class BaseDatos {

		private Connection conn;
		private String url = "jdbc:mysql://localhost:3306/clinica";
		private String username = "root";
		private String password = "Printesa28";

		public BaseDatos() {
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public Medico obtenerMedicoPorId(int id) {
	        Medico medico = null;
	        String query = "SELECT * FROM medicos WHERE id = ?";
	        try {
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                medico = new Medico();
	                medico.setId(resultSet.getInt("id"));
	                medico.setNombre(resultSet.getString("nombre"));
	                medico.setApellidos(resultSet.getString("apellidos"));
	                medico.setEspecialidad(resultSet.getString("especialidad"));
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return medico;

		public List<Medico> obtenerMedicosPorEspecialidad(String especialidad) {
	            List<Medico> medicos = new ArrayList<>();
	            String query = "SELECT * FROM medicos WHERE especialidad = ?";
	            try {
	                PreparedStatement statement = connection.prepareStatement(query);
	                statement.setString(1, especialidad);
	                ResultSet resultSet = statement.executeQuery();
	                while (resultSet.next()) {
	                    Medico medico = new Medico();
	                    medico.setId(resultSet.getInt("id"));
	                    medico.setNombre(resultSet.getString("nombre"));
	                    medico.setApellidos(resultSet.getString("apellidos"));
	                    medico.setEspecialidad(resultSet.getString("especialidad"));
	                    medicos.add(medico);
	                }
	                resultSet.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return medicos;

		public List<Paciente> obtenerPacientesPorMedico(int medicoId) {
			List<Paciente> pacientes = new ArrayList<>();
			String query = "SELECT * FROM pacientes WHERE medico_id = ?";
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, medicoId);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Paciente paciente = new Paciente();
					paciente.setId(resultSet.getInt("id"));
					paciente.setNombre(resultSet.getString("nombre"));
					paciente.setApellidos(resultSet.getString("apellidos"));
					paciente.setFechaAlta(resultSet.getDate("fecha_alta"));
					pacientes.add(paciente);
				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pacientes;
		}

		public void darDeAltaMedico(Medico medico) {
			String query = "INSERT INTO medicos (nombre, apellidos, especialidad) VALUES (?, ?, ?)";
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, medico.getNombre());
				statement.setString(2, medico.getApellidos());
				statement.setString(3, medico.getEspecialidad());
				statement.executeUpdate();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void eliminarMedicoPorId(int id) {
	                String query = "DELETE FROM medicos WHERE id
	            
	            
	            
	            
	        

	}

}
