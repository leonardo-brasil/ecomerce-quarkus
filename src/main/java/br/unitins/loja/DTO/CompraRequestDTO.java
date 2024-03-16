package br.unitins.loja.DTO;

import java.util.Date;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record CompraRequestDTO(@NotNull @PositiveOrZero(message = "O valor deve ser positivo ou zero") Double valor, @NotNull @PastOrPresent(message = "Uma compra não pode ser feita no futuro") Date data, @NotNull Long idUsuario) {
}
