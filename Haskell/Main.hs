import Data.List

-- Definição de tipos
type Evento = String

type Agenda = [Evento]

adicionarEvento :: Agenda -> IO ()
adicionarEvento agenda = do
  putStrLn "Digite o evento a ser adicionado:"
  evento <- getLine
  let novaAgenda = agenda ++ [evento]
  loop novaAgenda

removerEvento :: Agenda -> IO ()
removerEvento agenda = do
  putStrLn "Digite o índice do evento a ser removido:"
  indice <- getLine
  let novaAgenda = delete (agenda !! (read indice)) agenda
  loop novaAgenda

mostrarEventos :: Agenda -> IO ()
mostrarEventos agenda = do
  putStrLn "Eventos na Agenda:"
  mapM_ putStrLn agenda
  loop agenda

-- Função principal
main :: IO ()
main = do
  putStrLn "Bem-vindo ao Gerenciador de Agenda!"
  loop []

-- Função de loop para interação com o usuário
loop :: Agenda -> IO ()
loop agenda = do
  putStrLn "\nSelecione uma opção:"
  putStrLn "1. Adicionar evento"
  putStrLn "2. Remover evento"
  putStrLn "3. Visualizar agenda"
  putStrLn "4. Sair"
  opcao <- getLine
  case opcao of
    "1" -> do
      adicionarEvento agenda
    "2" -> do
      removerEvento agenda
    "3" -> do
      mostrarEventos agenda
    "4" -> putStrLn "Saindo do programa..."
    _ -> do
      putStrLn "Opção inválida. Tente novamente."
      loop agenda
