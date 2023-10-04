# Árvore Binária

## Testes de performance

Os resultados dos testes de performance foram obtidos atraves do comando
de linux `/usr/bin/time`. Exemplo de output:

    0.08user 0.01system 0:00.07elapsed 125%CPU (0avgtext+0avgdata 33348maxresident)k
    0inputs+0outputs (0major+2643minor)pagefaults 0swaps

_Notas: memória usada leva em conta todo o processo do java_

- Inserção de 100 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.05s
        Porcentagem máxima da CPU: 141%
        Máximo de memória usada: 33.15 MB

- Inserção de 500 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.09s
        Porcentagem máxima da CPU: 105%
        Máximo de memória usada: 32.13MB

- Inserção de 1000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.07s
        Porcentagem máxima da CPU: 144%
        Máximo de memória usada: 33.35MB

- Inserção de 10000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.05s
        Porcentagem máxima da CPU: 141%
        Máximo de memória usada: 32.95MB

- Inserção de 20000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.07s
        Porcentagem máxima da CPU: 136%
        Máximo de memória usada: 32.45MB

- Busca com inserção de 20000 elementos aleatórios:

        Tempo elapsado: 0ms

- Remoção com inserção de 20000 elementos aleatórios:

        Tempo elapsado: 1ms

- 50000 elementos aleatórios:

        Inserção demorou 8 ms
        Busca demorou 0 ms
        Remoção demorou 0 ms
