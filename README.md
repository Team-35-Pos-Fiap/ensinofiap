# Sistema de Feedback para Cursos On-line

Descrição
---------
O sistema permite que estudantes enviem feedbacks sobre cursos on-line, que administradores acompanhem a satisfação dos alunos, que notificações sejam enviadas para itens críticos e que relatórios periódicos sejam gerados para análise.

Principais funcionalidades
-------------------------
- Recebimento de feedbacks (avaliação, comentários, categoria, curso, usuário).
- Identificação e notificação automática para feedbacks.
- Geração de relatórios periódicos (diário/semana/mês) com métricas de satisfação.

Arquitetura e stack
-------------------
- Linguagem: Java
- Framework: Spring Boot
- Build: Maven
- Banco de dados: SQL (configurável via `spring.datasource.*`)
- Camadas: API REST, serviço de processamento, agendador de relatórios, serviço de notificação

Endpoints principais (exemplos)
-------------------------------

Notificações
------------


Relatórios e agendamento
------------------------


Banco de dados
--------------------------
