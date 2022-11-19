FROM python:3.11-slim-buster

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY check_releng_config_consistency.py .

CMD [ "python3" ]
ENTRYPOINT [ "./check_releng_config_consistency.py" ]