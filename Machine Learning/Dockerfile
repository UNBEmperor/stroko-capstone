FROM python:3.11-slim
WORKDIR /app
ENV PORT 8080
COPY . .
RUN pip install --upgrade pip && pip install -r requirements.txt
EXPOSE 8080
CMD ["gunicorn", "-b", "0.0.0.0:8080", "main:app"]