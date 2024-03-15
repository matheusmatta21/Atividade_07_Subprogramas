#include <stdio.h>

float somar(float num1, float num2)
{
	return num1 + num2;
}
float subtrair(float num1, float num2)
{
	return num1 - num2;
}
float multiplicar(float num1, float num2)
{
	return num1 * num2;
}
float dividir(float num1, float num2)
{
	if (num2 != 0)
	{
		return num1 / num2;
	}
	printf("Erro! Divisão por 0.\n");
}

void mostrarResultado(float operacao)
{
	printf("Resultado: %.2f\n", operacao);
}

int main()
{
	char operador;
	float num1, num2;
	printf("Digite a operação (+, -, *, /): ");
	scanf("%c", &operador);
	printf("Digite o primeiro número: ");
	scanf("%f", &num1);
	printf("Digite o segundo número: ");
	scanf("%f", &num2);
	switch (operador)
	{
	case '+':
		mostrarResultado(somar(num1, num2));
		break;
	case '-':
		mostrarResultado(subtrair(num1, num2));
		break;
	case '*':
		mostrarResultado(multiplicar(num1, num2));
		break;
	case '/':
		mostrarResultado(dividir(num1, num2));
		break;
	default:
		printf("Operador inválido.\n");
	}
	return 0;
}
