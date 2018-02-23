package com.daou.waiter.interceptor;


import com.daou.waiter.model.PageModel;
import com.daou.waiter.util.ParameterMapper;
import com.daou.waiter.util.SortUtil;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PageParameterResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // TODO Auto-generated method stub
        return parameter.getParameterType() == Pageable.class;
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // TODO Auto-generated method stub
        PageModel model = (PageModel) ParameterMapper.requestParamaterToObject(webRequest, PageModel.class);
        Sort sort = SortUtil.direction(model.getOrder(), model.getField());
        return new PageRequest(model.getPage(), model.getSize(), sort);
    }

}