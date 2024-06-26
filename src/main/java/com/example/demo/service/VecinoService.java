package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmailSenderService;
import com.example.demo.modelo.Vecino;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.repository.VecinoRepository;
import com.example.demo.repository.VecinoregistradoRepository;

@Service
public class VecinoService {
	@Autowired
	VecinoRepository repoVecino;
	@Autowired
	VecinoregistradoRepository repoVecinoRegistrado;

	@Autowired
	EmailSenderService emailSender;

//	NUEVOOOOOOOOO: Despues entrega
	public Vecino perfilVecinoregistrado(String mail) {
		// Trae una lista con un solo vecino
		List<Vecinoregistrado> vecinos = repoVecinoRegistrado.findByMail(mail);
		Vecinoregistrado vecinoRegistrado = null;
		for (Vecinoregistrado v : vecinos) {
			vecinoRegistrado = v;
		}
		if (vecinoRegistrado != null) {
			String documento = vecinoRegistrado.getDocumento();
			Optional<Vecino> vecinoOptional = repoVecino.findById(documento);
			if (vecinoOptional.isPresent()) {
				Vecino perfil = vecinoOptional.get();
				return perfil;
			} else {
				return null;
			}

		} else {
			return null;
		}

	}

	public String register2(String documento, String mail) {
		Optional<Vecinoregistrado> vecinoYaRegistrado = repoVecinoRegistrado.findById(documento);
		if (vecinoYaRegistrado.isPresent()) {
			System.out.println("Entro aca en ya esta registrado");
			return "YA ESTAS REGISTRADO";
		} else {
			Optional<Vecino> vecinoOptional = repoVecino.findById(documento);
			if (vecinoOptional.isPresent()) {
				List<Vecinoregistrado> mails = repoVecinoRegistrado.findByMail(mail);
				for (Vecinoregistrado v : mails) {
					if (v.getMail().equals(mail)) {
						System.out.println("Entro aca en el mail ya existe");
						return "El mail ya existe";
					}
				}
				String contrasenia = documento;
				Vecinoregistrado nuevoVecino = new Vecinoregistrado(documento, mail, contrasenia, "B", "S");
				repoVecinoRegistrado.save(nuevoVecino);
				emailSender.sendEmail("ignaciodorigo@gmail.com", "Registro en App MiMuni",
						"Estimado vecino, su registro en la App fue exitoso. Tenga en cuenta que la habilitación puede demorar hasta 15 días hábiles. Su contraseña provisoria es "
								+ nuevoVecino.getContrasenia());
				return "Registro exitoso";
			} else {
				System.out.println("Entro aca: No es vecino");
				return "No puede registrarse porque no es vecino";
			}
		}
	}

	public String olvideContrasenia(String mail) {
		List<Vecinoregistrado> vecinosConEseMail = repoVecinoRegistrado.findByMail(mail);
		Vecinoregistrado vecino = null;
		for (Vecinoregistrado v : vecinosConEseMail) {
			vecino = v;
		}
		if (vecino == null) {
			return "No estas registrado";
		} else {
			emailSender.sendEmail("ignaciodorigo@gmail.com", "Contrasenia enviada",
					"Tu contrasenia es " + vecino.getContrasenia());
			return "Correo enviado correctamente";
		}
	}

	public String login(String mail, String contrasenia) {
		List<Vecinoregistrado> mails = repoVecinoRegistrado.findByMail(mail);
		Vecinoregistrado vecino = null;
		for (Vecinoregistrado v : mails) {
			vecino = v;
		}
		if (vecino == null) {
			return "No estas registrado";
		} else {
			if (vecino.getMail().equals(mail) && vecino.getContrasenia().equals(contrasenia)) {
				if (vecino.getEstado().equals("B")) {
					return "Tu cuenta no está habilitada";
				} else {
					return "Ingreso exitoso";
				}

			} else {
				return "Datos incorrectos";
			}
		}
	}
}