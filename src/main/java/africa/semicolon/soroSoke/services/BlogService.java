package africa.semicolon.soroSoke.services;

import africa.semicolon.soroSoke.dto.request.BlogRequest;
import africa.semicolon.soroSoke.dto.response.BlogResponse;

public interface BlogService {
BlogResponse blogResponse(BlogRequest blogRequest );
}
