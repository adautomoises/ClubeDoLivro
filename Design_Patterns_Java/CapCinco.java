// ENVOLVENDO OBJETOS
public class CapCinco {
    public static void main(String[] args) {

    }
}

// Padrões Proxies e Decorators
// Esses dois padrões são muito semelhantes, ambos utilizam-se de composição recursiva, a principal
// diferença é o que o objetivo do Decorator é adicionar novas funcionalidades, já o Proxy protege
// o acesso ao objeto da classe original e sua criação que pode ter alto custo computacional.
// O que o Proxy faz também pode ser considerado uma funcionalidade.


// Padrão DAO
// Visa isolar o acesso a dados de uma aplicação. Podemos usar o Proxy ou Decorator para adicionar
// alguma funcionalidade, como isolar a classe original ou adicionar cache ao DAO.


// Padrão Adapter
// O Adapter traduz as chamadas da interface que ele implementa para a classe que ele encapsula.
// Semelhante aos Proxies e Decorators, com a exceção de que não possui a mesma interface da
// classe encapsulada, pois o seu objetivo é a adaptação de uma interface para outra.

interface SMSSender {
    boolean sendSMS(SMS sms);
}

class SMS {
    private String destino;
    private String origem;
    private String texto;

    public SMS(String destino, String origem, String texto) {
        this.destino = destino;
        this.origem = origem;
        this.texto = texto;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public String getTexto() {
        return texto;
    }
}

interface EnviadorSMS {
    void enviarSMS(String destino, String origem, String[] msgs) throws SMSException;
}

class SMSAdapter implements SMSSender {
    private EnviadorSMS enviadorSMS;

    public SMSAdapter(EnviadorSMS enviadorSMS) {
        this.enviadorSMS = enviadorSMS;
    }

    @Override
    public boolean sendSMS(SMS sms) {
        String destino = sms.getDestino();
        String origem = sms.getOrigem();
        String[] texto = quebrarMsgs(sms.getTexto());
        try {
            enviadorSMS.enviarSMS(destino, origem, texto);
        } catch (SMSException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String[] quebrarMsgs(String texto) {
        int tamanhoTexto = texto.length();
        int quantidade = (tamanhoTexto % 160 == 0) ? tamanhoTexto / 160 : tamanhoTexto / 160 + 1;
        String[] msgs = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            int min = i * 160;
            int max = (i == quantidade - 1) ? tamanhoTexto : (i + 1) * 160;
            msgs[i] = texto.substring(min, max);
        }
        return msgs;
    }
}

// Classe de Exceção criada para o exemplo
class SMSException extends Exception {
    public SMSException() {
        super();
    }

    public SMSException(String msg) {
        super(msg);
    }

    public SMSException(String msg, Throwable causa) {
        super(msg, causa);
    }

    public SMSException(Throwable causa) {
        super(causa);
    }
}